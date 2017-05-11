import { Component } from '@angular/core';
import { Storage } from '@ionic/storage';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import { NavController } from 'ionic-angular';
import { JwtHelper } from 'angular2-jwt';
import { Login } from '../login/login';
import { OrganizationService } from '../../providers/organizationService';
import { TeamService } from '../../providers/teamService';

@Component({
  selector: 'page-createMatch',
  templateUrl: 'createMatch.html',
  providers: [OrganizationService, TeamService]
})
export class CreateMatch {

  createMatchForm: FormGroup;
  jwtHelper: JwtHelper;
  listOrgnization: any;
  listTeam: any;

	constructor(public storage: Storage, public navCtrl: NavController, public formBuilder: FormBuilder, private organizationService: OrganizationService, private teamService: TeamService) {
		console.log('Constructor CreateOrganization');
    //Inicializamos las variables del match
    this.createMatchForm = formBuilder.group({
      idOrganization: ['0', Validators.compose([Validators.required])],
      idHomeTeam: ['0', Validators.compose([Validators.required])],
      idAwayTeam: ['0', Validators.compose([Validators.required])],
      date: ['', Validators.compose([Validators.required])],
      numQuarter: ['', Validators.compose([Validators.required])],
      quarterTime: ['', Validators.compose([Validators.required])],
      numRest: [''],
      restTime: [''],
      faulsAllowedTeam: [''],
      faulsAllowedPlayer: ['']
    });
    this.jwtHelper = new JwtHelper();
    this.storage.ready().then(()=>
      this.storage.get('id_token').then((token) => {
        //Si el token a expirado nos vamos a la pagina de bienvenida
        if(this.jwtHelper.isTokenExpired(token)){
          this.navCtrl.setRoot(Login);
        }else{

          //Cargamos la lista de organizaciones
          this.organizationService.findAdministratedByPrincipal(token).subscribe(

            data => {

              this.listOrgnization = data;
              if(this.listOrgnization!= null && this.listOrgnization.length>0){
                this.createMatchForm.value.idOrganization = this.listOrgnization[0].id;
                if(this.createMatchForm.value.idOrganization!=null && this.createMatchForm.value.idOrganization!='') {
                  this.teamService.findTeamsByIdOrganization(this.createMatchForm.value.idOrganization,token).subscribe(data => this.listTeam = data);
                }
              }else {
                this.createMatchForm.value.idOrganization = '0';
              }

            },
            err => {
              console.log(err);
            },
            () => console.log('Call to organizationService.findAdministratedByPrincipal finished')


          );

        }
      }));

	}

  createMatch(){
	  console.log("Metodo para crear un partido");
  }

}
