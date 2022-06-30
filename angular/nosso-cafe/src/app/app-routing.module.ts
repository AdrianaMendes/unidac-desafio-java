import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ColaboradorPage } from '@pages/colaborador/colaborador.page';
import { HomePage } from '@pages/home/home.component';
import { SettingPage } from '@pages/setting/setting.page';

const routes: Routes = [
	{
		path: '',
		pathMatch: 'full',
		component: HomePage,
	},
	{
		path: 'colaborador',
		pathMatch: 'full',
		component: ColaboradorPage,
	},
	{
		path: 'setting',
		pathMatch: 'full',
		component: SettingPage,
	},
];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule],
})
export class AppRoutingModule {}
