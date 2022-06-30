import { HttpErrorResponse } from '@angular/common/http';
import { Component, Inject } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { TModal } from '@custom-types/modal.type';
import { IMantimentoFormGroup } from '@interfaces/mantimento.interface';
import { MantimentoService } from '@services/mantimento.service';

@Component({
	templateUrl: './modal-mantimento.component.html',
})
export class ModalMantimentoComponent {
	modalType!: TModal;
	form!: IMantimentoFormGroup;
	isReadonly!: boolean;

	constructor(
		private readonly service: MantimentoService,
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
					descricao: [undefined, Validators.required],
				}) as unknown as IMantimentoFormGroup;
				break;
			case 'edit':
			case 'view':
				this.form = this.formBuilder.group({
					id: [this.data.form.id],
					descricao: [this.data.form.descricao, Validators.required],
				}) as unknown as IMantimentoFormGroup;
				break;
		}
	}

	onSubmit(): void {
		switch (this.modalType) {
			case 'add':
				this.service.save(this.form.value).subscribe({
					next: () => {
						this.dialogRef.close();
					},
					error: (error: HttpErrorResponse) => {
						console.error(error);
					},
				});
				break;
			case 'edit':
				this.service.update(this.form.value).subscribe({
					next: () => {
						this.dialogRef.close();
					},
					error: (error: HttpErrorResponse) => {
						console.error(error);
					},
				});
				break;
		}
	}
}
