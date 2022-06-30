export interface ISideMenu {
	text: string;
	icon?: string;
	routerLink?: string;
	children?: ISideMenu[];
}
