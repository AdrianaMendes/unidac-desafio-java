import { HttpErrorResponse } from '@angular/common/http';
import { Component, Inject } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { TModal } from '@custom-types/modal.type';
import { IColaboradorFormGroup } from '@interfaces/colaborador.interface';
import { IMantimento } from '@interfaces/mantimento.interface';
import { ColaboradorService } from '@services/colaborador.service';
import { MantimentoService } from '@services/mantimento.service';
import Swal from 'sweetalert2';

@Component({
	templateUrl: './modal-colaborador.component.html',
})
export class ModalColaboradorComponent {
	modalType!: TModal;
	form!: IColaboradorFormGroup;
	isReadonly!: boolean;
	listaMantimentosComboBox: IMantimento[] = [];

	constructor(
		private readonly service: ColaboradorService,
		private readonly mantimentoService: MantimentoService,
		private readonly formBuilder: FormBuilder,
		private readonly dialogRef: MatDialogRef<any>,
		@Inject(MAT_DIALOG_DATA) private readonly data: any,
	) {
		this.modalType = this.data.modalType;
		this.isReadonly = this.modalType === 'view';

		this.mantimentoService.findAll().subscribe({
			next: (response) => {
				this.listaMantimentosComboBox = response;
			},
		});

		switch (this.modalType) {
			case 'add':
				this.form = this.formBuilder.group({
					id: [undefined],
					nome: [undefined, Validators.required],
					cpf: [undefined, Validators.required],
					listaMantimentos: [undefined],
				}) as unknown as IColaboradorFormGroup;
				break;
			case 'edit':
			case 'view':
				this.form = this.formBuilder.group({
					id: [this.data.form.id],
					nome: [this.data.form.nome, Validators.required],
					cpf: [this.data.form.cpf, Validators.required],
					listaMantimentos: [this.data.form.listaMantimentos],
				}) as unknown as IColaboradorFormGroup;
				break;
		}
	}

	onSubmit(): void {
		switch (this.modalType) {
			case 'add':
				this.service.save(this.form.value).subscribe({
					next: () => {
						Swal.fire({
							position: 'center',
							icon: 'success',
							title: 'Salvo com sucesso',
							showConfirmButton: false,
							backdrop: false,
							timer: 1500,
						});
						this.dialogRef.close();
					},
					error: (error: HttpErrorResponse) => {
						if (error?.error?.cpf) {
							Swal.fire(error.error?.cpf, '', 'error');
						} else {
							Swal.fire(error.error?.message, '', 'error');
						}
						console.error(error);
						this.dialogRef.close();
					},
				});
				break;
			case 'edit':
				this.service.update(this.form.value).subscribe({
					next: () => {
						Swal.fire({
							position: 'center',
							icon: 'success',
							title: 'Editado com sucesso',
							showConfirmButton: false,
							backdrop: false,
							timer: 1500,
						});
						this.dialogRef.close();
					},
					error: (error: HttpErrorResponse) => {
						Swal.fire(error.error.message, '', 'error');
						console.error(error);
						this.dialogRef.close();
					},
				});
				break;
		}
	}

	compararMantimento(m1: IMantimento, m2: IMantimento): boolean {
		return m1 && m2 && m1.id === m2.id;
	}
}
