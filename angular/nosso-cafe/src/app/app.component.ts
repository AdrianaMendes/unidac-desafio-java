import { MediaMatcher } from '@angular/cdk/layout';
import { ChangeDetectorRef, Component, OnDestroy, OnInit } from '@angular/core';
import { ISideMenu } from '@interfaces/side-menu.interface';
import { TranslateService } from '@ngx-translate/core';
import { firstValueFrom } from 'rxjs';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.scss'],
})
export class AppComponent implements OnDestroy, OnInit {
	menuList: ISideMenu[] = [];
	mobileQuery!: MediaQueryList;
	private _mobileQueryListener: () => void;

	constructor(private readonly translateService: TranslateService, changeDetectorRef: ChangeDetectorRef, media: MediaMatcher) {
		this.mobileQuery = media.matchMedia('(max-width: 600px)');
		this._mobileQueryListener = (): void => changeDetectorRef.detectChanges();
		this.mobileQuery.addEventListener('change', this._mobileQueryListener);

		const language: string = localStorage.getItem('language')!;
		if (language) {
			this.translateService.use(language);
		} else {
			localStorage.setItem('language', 'pt-BR');
			this.translateService.use('pt-BR');
		}
	}

	async ngOnInit(): Promise<void> {
		this.menuList = [
			{
				text: await firstValueFrom(this.translateService.get('text.home')),
				icon: 'home',
				routerLink: '/',
			},
			{
				text: await firstValueFrom(this.translateService.get('text.collaborator')),
				icon: 'people_alt',
				routerLink: '/colaborador',
			},
			{
				text: await firstValueFrom(this.translateService.get('text.setting')),
				icon: 'settings',
				routerLink: '/setting',
			},
		];
	}

	ngOnDestroy(): void {
		this.mobileQuery.removeEventListener('change', this._mobileQueryListener);
	}
}
