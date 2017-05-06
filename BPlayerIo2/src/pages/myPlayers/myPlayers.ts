import { Component } from '@angular/core';
import { Storage } from '@ionic/storage';
import { NavController } from 'ionic-angular';
import { JwtHelper } from 'angular2-jwt';
import { Login } from '../login/login';
import { OrganizationService } from '../../providers/organizationService';
import { TeamService } from '../../providers/teamService';
import { PlayerService } from '../../providers/playerService';

@Component({
  selector: 'page-myPlayers',
  templateUrl: 'myPlayers.html',
  providers: [OrganizationService, TeamService, PlayerService]
})
export class MyPlayers {

  listOrganizationDto : any;
  idOrganization: any;
  listTeamDto: any;
  idTeam: any;
  listPlayerDto: any;
  jwtHelper: JwtHelper;

	constructor(public storage: Storage, public navCtrl: NavController, private organizationService: OrganizationService, private teamService: TeamService, private playerService: PlayerService) {
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
                if(this.idOrganization!=null) {
                  this.teamService.findTeamsByIdOrganization(this.idOrganization,token).subscribe(data => this.listTeamDto = data);
                  this.playerService.findPlayersByIdOrganization(this.idOrganization,token).subscribe(data => this.listPlayerDto = data);
                }
              }else{
                this.idOrganization = 0;
              }
              this.idTeam = 0;
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
	  this.idTeam = 0;
    this.storage.ready().then(()=>
      this.storage.get('id_token').then((token) => {
        //Si el token a expirado nos vamos a la pagina de bienvenida
        if(this.jwtHelper.isTokenExpired(token)){
          this.navCtrl.setRoot(Login);
        }else{

          if(this.idOrganization!=null){
            this.teamService.findTeamsByIdOrganization(this.idOrganization,token).subscribe(data => this.listTeamDto = data);
            this.playerService.findPlayersByIdOrganization(this.idOrganization,token).subscribe(data => this.listPlayerDto = data);
          }

        }
      }));
  }

  selectIdTeam(){
    this.storage.ready().then(()=>
      this.storage.get('id_token').then((token) => {
        //Si el token a expirado nos vamos a la pagina de bienvenida
        if(this.jwtHelper.isTokenExpired(token)){
          this.navCtrl.setRoot(Login);
        }else{

          if(this.idOrganization!=null && this.idTeam!=null){
            if(this.idTeam!=0){
              this.playerService.findPlayersByIdTeam(this.idTeam,token).subscribe(data => this.listPlayerDto = data);
            }else{
              this.playerService.findPlayersByIdOrganization(this.idOrganization,token).subscribe(data => this.listPlayerDto = data);
            }

          }

        }
      }));
  }

}
