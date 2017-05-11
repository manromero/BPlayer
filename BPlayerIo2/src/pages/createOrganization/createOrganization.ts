import { Component } from '@angular/core';
import { Storage } from '@ionic/storage';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import { NavController, AlertController } from 'ionic-angular';
import { JwtHelper } from 'angular2-jwt';
import { Login } from '../login/login';
import { OrganizationService } from '../../providers/organizationService';

@Component({
  selector: 'page-createOrganization',
  templateUrl: 'createOrganization.html',
  providers: [OrganizationService]
})
export class CreateOrganization {

  createOrganizationForm: FormGroup;
  jwtHelper: JwtHelper;

	constructor(public storage: Storage, public navCtrl: NavController, public formBuilder: FormBuilder, private alertCtrl: AlertController, private organizationService: OrganizationService) {
		console.log('Constructor CreateOrganization');
    this.jwtHelper = new JwtHelper();
    this.storage.ready().then(()=>
      this.storage.get('id_token').then((token) => {
        //Si el token a expirado nos vamos a la pagina de bienvenida
        if(this.jwtHelper.isTokenExpired(token)){
          this.navCtrl.setRoot(Login);
        }
      }));
    this.createOrganizationForm = formBuilder.group({
      name: ['', Validators.compose([Validators.required, Validators.maxLength(50)])]
    });
	}

	createOrganization(){
    console.log('New Organization is trying to be created');
    //Tiene errores
    if(!this.createOrganizationForm.valid){
      //Se muestra una alerta de error
      let alert = this.alertCtrl.create({
        title: 'Organization Error',
        subTitle: 'Form has invalid values',
        buttons: ['OK']
      });
      alert.present();
    }else {
      console.log('There is not error in the form. Next Step: Call to provider');
      this.storage.ready().then(()=>
        this.storage.get('id_token').then((token) => {
          //Si el token a expirado nos vamos a la pagina de bienvenida
          if(this.jwtHelper.isTokenExpired(token)){
            this.navCtrl.setRoot(Login);
          }else{

            this.organizationService.create(this.createOrganizationForm.value, token).subscribe(
              data => {
                let alert = this.alertCtrl.create({
                  title: 'Organization created',
                  subTitle: 'The Organization has been created properly',
                  buttons: [{
                    text:'OK' , handler: () => {
                      this.navCtrl.pop();
                    }
                  }]
                });
                alert.present();
              },
              err => {
                console.log(err);
                let alert = this.alertCtrl.create({
                  title: 'Organization Error',
                  subTitle: 'An unexpected error has occurred',
                  buttons: ['OK']
                });
                alert.present();
              },
              () => console.log('Call to organization.create finished')
            );

          }
        }));
    }
  }

}
