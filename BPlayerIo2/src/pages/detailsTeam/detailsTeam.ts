import { Component } from '@angular/core';
import { Storage } from '@ionic/storage';
import { NavController, NavParams, AlertController } from 'ionic-angular';
import { JwtHelper } from 'angular2-jwt';
import { Login } from '../login/login';
import { Main } from '../main/main';
import { TeamService } from '../../providers/teamService';
import { PlayerService } from '../../providers/playerService';

@Component({
  selector: 'page-detailsTeam',
  templateUrl: 'detailsTeam.html',
  providers: [TeamService, PlayerService]
})
export class DetailsTeam {

  team: any;
  jwtHelper: JwtHelper;

	constructor(public storage: Storage, public navCtrl: NavController, public navParams: NavParams, private teamService: TeamService, private playerService: PlayerService, private alertCtrl: AlertController) {
		console.log('Constructor CreateTeam');
    this.jwtHelper = new JwtHelper();
    this.storage.ready().then(()=>
      this.storage.get('id_token').then((token) => {
        //Si el token a expirado nos vamos a la pagina de bienvenida
        if(this.jwtHelper.isTokenExpired(token)){
          this.navCtrl.setRoot(Login);
        }else{

          //LLamada al provider para recuperar los datos de la organization
          this.teamService.findDetailedTeamByIdTeam(navParams.get('idTeam'), token).subscribe(data => this.team = data);

        }

      }));
	}

  findListPlayerToAddToTeam(){

    console.log("Find Player that could be added to the team");
    //Antes de la llamada al web service necesitamos recuperar el token
    this.storage.ready().then(()=>
      this.storage.get('id_token').then((token) => {
        //Si el token a expirado nos vamos a la pagina de bienvenida
        if(this.jwtHelper.isTokenExpired(token)){
          this.navCtrl.setRoot(Login);
        }else{

          //LLamamos a la funcion que recupera los administradores
          this.playerService.findListPlayerToAddTeam(this.team.id, token).subscribe(


            data => {
              let lisPlayerToAddTeam: any[]  = data;
              console.log(lisPlayerToAddTeam);
              //Opciones de la alerta a mostrar
              var options = {
                title: 'Add a Player',
                buttons: [
                  {
                    text: 'Cancel',
                    role: 'cancel',
                    handler: () => {
                      console.log('Cancel clicked. No Team is added');
                    }
                  },
                  {
                    text: 'Add',
                    handler: data => {
                      console.log(data);
                      //Se actualiza la lista de administradores
                      this.playerService.addPlayerToTeam(data,this.team.id, token).subscribe(players => this.team.listPlayerDto = players);

                    }
                  }
                ],
                inputs : []
              }
              for(let i=0; i< lisPlayerToAddTeam.length; i++) {
                options.inputs.push({ name : 'options', value: lisPlayerToAddTeam[i].id, label: lisPlayerToAddTeam[i].name, type: 'radio' });
              }
              let alert = this.alertCtrl.create(options);
              alert.present();


            },
            err => {
              console.log(err);
            },
            () => console.log('Call to playerService.findListPlayerToAddTeam finished')
          );

        }

      }));

  }

  deleteTeam(){
    console.log("Delete Team");
    this.storage.ready().then(()=>
      this.storage.get('id_token').then((token) => {
        //Si el token a expirado nos vamos a la pagina de bienvenida
        if(this.jwtHelper.isTokenExpired(token)){
          this.navCtrl.setRoot(Login);
        }else{

          var options = {
            title: 'Do you want to delete this team?',
            buttons: [
              {
                text: 'Cancel',
                role: 'cancel',
                handler: () => {
                  console.log('Cancel clicked. Not to delete team');
                }
              },
              {
                text: 'Delete',
                handler: () => {
                  console.log('Call to provider to delete team');
                  let errorsToDelete: any;
                  this.teamService.deleteTeamByIdTeam(this.team.id, token).subscribe(


                    data => {

                      errorsToDelete = data;
                      //Si la respuesta contiene errrores, se ha producido un error inexperado
                      if(errorsToDelete.length>0){
                        let errorAlert = this.alertCtrl.create({
                          title: 'Register Error',
                          subTitle: 'An unexpected error has occurred',
                          buttons: ['OK']
                        });
                        errorAlert.present();
                      }else{
                        let confirmAlert = this.alertCtrl.create({
                          title: 'Team deleted properly',
                          subTitle: 'The team has been deleted',
                          buttons: [
                            {
                              text: 'OK',
                              handler: () => {
                                this.navCtrl.setRoot(Main);
                              }
                            }
                          ]
                        });
                        confirmAlert.present();
                      }

                    },
                    err => {
                      console.log(err);
                    },
                    () => console.log('Call to teamService.delete finished')

                  );


                }

              }
            ]
          }
          let alert = this.alertCtrl.create(options);
          alert.present();

        }

      }));
  }

}
