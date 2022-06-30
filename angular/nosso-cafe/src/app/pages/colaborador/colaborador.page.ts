import { HttpErrorResponse } from '@angular/common/http';
import { Component, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { TModal } from '@custom-types/modal.type';
import { IColaborador } from '@interfaces/colaborador.interface';
import { ColaboradorService } from '@services/colaborador.service';
import { ModalColaboradorComponent } from './modal-colaborador/modal-colaborador.component';

@Component({
	templateUrl: './colaborador.page.html',
})
export class ColaboradorPage {
	readonly displayedColumns: string[] = ['id', 'nome', 'cpf', 'action'];

	@ViewChild(MatPaginator) paginator!: MatPaginator;
	@ViewChild(MatSort) sort!: MatSort;
	dataSource: MatTableDataSource<IColaborador> = new MatTableDataSource();

	constructor(readonly service: ColaboradorService, private readonly matDialog: MatDialog) {}

	private refresh(): void {
		this.service.findAll().subscribe((response) => {
			this.dataSource = new MatTableDataSource(response);
			this.dataSource.paginator = this.paginator;
			this.dataSource.sort = this.sort;
		});
	}

	ngAfterViewInit(): void {
		this.refresh();
	}

	applyFilter(event: Event): void {
		const filterValue = (event.target as HTMLInputElement).value;
		this.dataSource.filter = filterValue.trim().toLowerCase();

		if (this.dataSource.paginator) {
			this.dataSource.paginator.firstPage();
		}
	}

	openModal(modalType: TModal, id?: number): void {
		const form = this.dataSource.data.find((x) => x.id === id);
		this.matDialog
			.open(ModalColaboradorComponent, { width: '80%', data: { modalType: modalType, form: form } })
			.afterClosed()
			.subscribe(() => {
				this.refresh();
			});
	}

	onDelete(id: number): void {
		this.service.delete(id).subscribe({
			next: () => {
				this.dataSource.data = this.dataSource.data.filter((x) => x.id !== id);
			},
			error: (error: HttpErrorResponse) => {
				console.error(error);
			},
		});
	}
}
