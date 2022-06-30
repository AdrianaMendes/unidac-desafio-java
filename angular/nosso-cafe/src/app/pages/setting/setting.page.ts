import { Component, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';

@Component({
	templateUrl: './setting.page.html',
})
export class SettingPage implements OnInit {
	language!: string;

	constructor(private readonly translateService: TranslateService) {}

	ngOnInit(): void {
		this.language = this.translateService.currentLang;
	}

	onChangeLanguage(): void {
		this.translateService.use(this.language);
		localStorage.setItem('language', this.language);
		window.location.reload();
	}
}
