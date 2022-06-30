import { HttpErrorResponse } from '@angular/common/http';
import { AfterViewInit, Component, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { TModal } from '@custom-types/modal.type';
import { IMantimento } from '@interfaces/mantimento.interface';
import { MantimentoService } from '@services/mantimento.service';
import { ModalMantimentoComponent } from './modal-mantimento/modal-mantimento.component';

@Component({
	templateUrl: './mantimento.page.html',
})
export class MantimentoPage implements AfterViewInit {
	readonly displayedColumns: string[] = ['id', 'descricao', 'action'];

	@ViewChild(MatPaginator) paginator!: MatPaginator;
	@ViewChild(MatSort) sort!: MatSort;
	dataSource: MatTableDataSource<IMantimento> = new MatTableDataSource();

	constructor(private readonly service: MantimentoService, private readonly matDialog: MatDialog) {}

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
			.open(ModalMantimentoComponent, { width: '50%', data: { modalType: modalType, form: form } })
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
