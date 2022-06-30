import { HttpErrorResponse } from '@angular/common/http';
import { Component, Inject } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { TModal } from '@custom-types/modal.type';
import { IColaboradorFormGroup } from '@interfaces/colaborador.interface';
import { ColaboradorService } from '@services/colaborador.service';

@Component({
	templateUrl: './modal-colaborador.component.html',
})
export class ModalColaboradorComponent {
	modalType!: TModal;
	form!: IColaboradorFormGroup;
	isReadonly!: boolean;

	constructor(
		private readonly service: ColaboradorService,
		private readonly formBuilder: FormBuilder,
		private readonly dialogRef: MatDialogRef<any>,
		@Inject(MAT_DIALOG_DATA) private readonly data: any,
	) {
		this.modalType = this.data.modalType;
		this.isReadonly = this.modalType === 'view';

		switch (this.modalType) {
			case 'add':
				this.form = this.formBuilder.group({
					id: [undefined],
					nome: [undefined, Validators.required],
					cpf: [undefined, Validators.required],
				}) as unknown as IColaboradorFormGroup;
				break;
			case 'edit':
			case 'view':
				this.form = this.formBuilder.group({
					id: [this.data.form.id],
					nome: [this.data.form.nome, Validators.required],
					cpf: [this.data.form.cpf],
				}) as unknown as IColaboradorFormGroup;
				break;
		}
	}

	onSubmit(): void {
		this.service.save(this.form.value).subscribe({
			next: () => {
				this.dialogRef.close();
			},
			error: (error: HttpErrorResponse) => {
				console.error(error);
			},
		});
	}
}
