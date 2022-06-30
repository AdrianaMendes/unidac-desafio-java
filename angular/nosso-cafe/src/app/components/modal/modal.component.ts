import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
	selector: 'app-modal',
	templateUrl: './modal.component.html',
})
export class ModalComponent {
	@Input() title!: string;
	@Input() isValid!: boolean;
	@Input() hasAction: boolean = true;
	@Output() eventEmitterSubmit = new EventEmitter<void>();

	onSubmit(): void {
		this.eventEmitterSubmit.emit();
	}
}
