import { FormGroup, AbstractControl } from '@angular/forms';
import { IEntity } from './entity.interface';

export interface IMantimento extends IEntity {
	descricao: string;
}

export interface IMantimentoFormGroup extends FormGroup {
	value: IMantimento;
	controls: {
		id: AbstractControl;
		descricao: AbstractControl;
	};
}
