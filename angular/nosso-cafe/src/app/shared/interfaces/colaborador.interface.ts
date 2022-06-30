import { FormGroup, AbstractControl } from '@angular/forms';
import { IEntity } from './entity.interface';
import { IMantimento } from './mantimento.interface';

export interface IColaborador extends IEntity {
	nome: string;
	cpf: string;
	listaMantimentos: IMantimento[];
}

export interface IColaboradorFormGroup extends FormGroup {
	value: IColaborador;
	controls: {
		id: AbstractControl;
		nome: AbstractControl;
		cpf: AbstractControl;
		listaMantimentos: AbstractControl;
	};
}
