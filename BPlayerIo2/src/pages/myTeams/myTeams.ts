import { Component } from '@angular/core';
import { Storage } from '@ionic/storage';
import { NavController } from 'ionic-angular';
import { JwtHelper } from 'angular2-jwt';
import { Login } from '../login/login';
import { OrganizationService } from '../../providers/organizationService';
import { TeamService } from '../../providers/teamService';

@Component({
  selector: 'page-myTeams',
  templateUrl: 'myTeams.html',
  providers: [OrganizationService, TeamService]
})
export class MyTeams {

  idOrganization: any;
  listOrganizationDto : any;
  listTeamDto: any;
  jwtHelper: JwtHelper;

	constructor(public storage: Storage, public navCtrl: NavController, private organizationService: OrganizationService, private teamService: TeamService) {
		console.log('Constructor MyOrganizations');
    this.jwtHelper = new JwtHelper();
    this.storage.ready().then(()=>
      this.storage.get('id_token').then((token) => {
        //Si el token a expirado nos vamos a la pagina de bienvenida
        if(this.jwtHelper.isTokenExpired(token)){
          this.navCtrl.setRoot(Login);
        }else{

          //Recuperamos la lista de organizations que tiene el usuario actual
          this.organizationService.findAdministratedByPrincipal(token).subscribe(

            data => {
              this.listOrganizationDto = data;
              if(this.listOrganizationDto!= null && this.listOrganizationDto.length>0){
                this.idOrganization = this.listOrganizationDto[0].id;
                this.teamService.findTeamsByIdOrganization(this.idOrganization,token).subscribe(teams => this.listTeamDto = teams);
              }else{
                this.idOrganization = 0;
              }
            },
            err => {
              console.log(err);
            },
            () => console.log('Call to bUserService.register finished')

          );

        }
      }));
	}

	selectIdOrganization(){
    this.storage.ready().then(()=>
      this.storage.get('id_token').then((token) => {
        //Si el token a expirado nos vamos a la pagina de bienvenida
        if(this.jwtHelper.isTokenExpired(token)){
          this.navCtrl.setRoot(Login);
        }else{

          if(this.idOrganization!=null){
            this.teamService.findTeamsByIdOrganization(this.idOrganization,token).subscribe(data => this.listTeamDto = data);
          }

        }
      }));
  }

}
