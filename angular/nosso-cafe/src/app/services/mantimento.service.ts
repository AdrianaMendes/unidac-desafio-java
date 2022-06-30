import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IMantimento } from '@interfaces/mantimento.interface';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
	providedIn: 'root',
})
export class MantimentoService {
	private readonly url: string = `${environment.apiUrl}/mantimento`;

	constructor(private readonly httpClient: HttpClient) {}

	delete(id: number): Observable<void> {
		return this.httpClient.delete<void>(`${this.url}/delete/${id}`);
	}

	findAll(): Observable<IMantimento[]> {
		return this.httpClient.get<IMantimento[]>(`${this.url}/findAll`);
	}

	save(request: IMantimento): Observable<void> {
		return this.httpClient.post<void>(`${this.url}/save`, request);
	}
}
