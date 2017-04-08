import { Component } from '@angular/core';
import { Storage } from '@ionic/storage';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import { NavController, AlertController } from 'ionic-angular';
import { BUserService } from '../../providers/bUserService';
import { JwtHelper } from 'angular2-jwt';
import { Main } from '../main/main';


@Component({
	selector: 'page-login',
	templateUrl: 'login.html',
	providers: [BUserService]
})
export class Login {
  accountCredentialsForm: FormGroup;
	jwtHelper: JwtHelper;
	token: any;

	constructor(private bUserService: BUserService, public storage: Storage, public formBuilder: FormBuilder, private alertCtrl: AlertController, public navCtrl: NavController) {
		console.log('Constructor Login');
		this.accountCredentialsForm = formBuilder.group({
      username: ['', Validators.compose([Validators.required, Validators.maxLength(50)])],
      password: ['', Validators.compose([Validators.required, Validators.maxLength(50)])]
    });
		this.jwtHelper = new JwtHelper();
	}

	login(){
		console.log("A BUser is trying to Login");
		//Primero eliminaremos el id token que estuviera creado
    this.storage.ready().then(()=> {
      this.storage.set('id_token','');
      //Si el form esta validado se procede a realizar la del bUserService.login
      if(this.accountCredentialsForm.valid) {
        this.bUserService.login(this.accountCredentialsForm.value).subscribe(
          data => {
            this.navCtrl.setRoot(Main);
          },
          err => {
            console.error(err);
            //No se pudo hacer login
            //Se muestran los errores del mensaje por alert
            let alert = this.alertCtrl.create({
              title: 'Login error',
              subTitle: 'There is not a BUser with that Username and Password',
              buttons: ['Dismiss']
            });
            alert.present();
          },
          () => console.log('LLamada a bUserService.register finalizada')
        );
      }else{
        //Se muestra una alerta de error
          let alert = this.alertCtrl.create({
            title: 'Login error',
            subTitle: 'Form has invalid values',
            buttons: ['OK']
          });
          alert.present();
      }
    });
	}


}
