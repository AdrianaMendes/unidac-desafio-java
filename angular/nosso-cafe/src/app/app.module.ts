import { HttpClient, HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FlexLayoutModule } from '@angular/flex-layout';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialDesignModule } from '@modules/material-desing.module';

import { TranslateLoader, TranslateModule } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { ColaboradorPage } from '@pages/colaborador/colaborador.page';
import { ModalColaboradorComponent } from '@pages/colaborador/modal-colaborador/modal-colaborador.component';
import { HomePage } from '@pages/home/home.component';
import { SettingPage } from '@pages/setting/setting.page';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ModalComponent } from './components/modal/modal.component';

@NgModule({
	declarations: [AppComponent, HomePage, SettingPage, ColaboradorPage, ModalComponent, ModalColaboradorComponent],
	imports: [
		BrowserModule,
		AppRoutingModule,
		TranslateModule.forRoot({
			loader: {
				provide: TranslateLoader,
				useFactory: HttpLoaderFactory,
				deps: [HttpClient],
			},
		}),
		HttpClientModule,
		BrowserAnimationsModule,
		MaterialDesignModule,
		FlexLayoutModule,
		FormsModule,
		ReactiveFormsModule,
	],
	bootstrap: [AppComponent],
})
export class AppModule {}

export function HttpLoaderFactory(http: HttpClient): TranslateHttpLoader {
	return new TranslateHttpLoader(http);
}
