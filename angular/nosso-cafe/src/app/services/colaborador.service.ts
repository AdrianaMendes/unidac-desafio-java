import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IColaborador } from '@interfaces/colaborador.interface';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
	providedIn: 'root',
})
export class ColaboradorService {
	private readonly url: string = `${environment.apiUrl}/colaborador`;

	constructor(private readonly httpClient: HttpClient) {}

	addMantimento(colaboradorId: number, mantimentoId: number): Observable<void> {
		return this.httpClient.put<void>(`${this.url}/addMantimento/${colaboradorId}/${mantimentoId}`, null);
	}

	delete(id: number): Observable<void> {
		return this.httpClient.delete<void>(`${this.url}/delete/${id}`);
	}

	findAll(): Observable<IColaborador[]> {
		return this.httpClient.get<IColaborador[]>(`${this.url}/findAll`);
	}

	save(request: IColaborador): Observable<void> {
		return this.httpClient.post<void>(`${this.url}/save`, request);
	}
}
