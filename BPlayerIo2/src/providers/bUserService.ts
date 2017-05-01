import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions, Response} from '@angular/http';
import { Storage } from '@ionic/storage';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

/*
  Generated class for the BUser provider.

  See https://angular.io/docs/ts/latest/guide/dependency-injection.html
  for more info on providers and Angular 2 DI.
*/
@Injectable()
export class BUserService {

  API_ENDPOINT = 'http://localhost:8081/'

	constructor(public http: Http, public storage: Storage) {
		console.log('Constructor BUserService');
	}

	login(accountCredentials){
		console.log('Se procede a realizar la llamada a /login');
		let body = JSON.stringify(accountCredentials);
		let headers = new Headers({ 'Content-Type': 'application/json'});
		let options = new RequestOptions({ headers: headers });
		var response = this.http.post(this.API_ENDPOINT+'login', body, options).map(res =>  {
			let token = res.headers.get("Authorization");
      this.storage.set('id_token', token);
			return res.headers.get("Authorization");
		}).catch(this.handleError);
		return response;
	}

	register(bUserToRegisterDto) {
		console.log('Se procede a realizar la llamada a buser/register')
		let body = JSON.stringify(bUserToRegisterDto);
		let headers = new Headers({ 'Content-Type': 'application/json'});
		let options = new RequestOptions({ headers: headers });
		var response = this.http.post(this.API_ENDPOINT+'bUser/register', body, options).map(res => res.json()).catch(this.handleError);
		return response;
	}

  findListBUserToBeAdministrator(idOrganization, token){
    let headers = new Headers({ 'Content-Type': 'application/json', 'Authorization' : token});
    let options = new RequestOptions({ headers: headers });
    let url = this.API_ENDPOINT+'bUser/findListBUserToBeAdministrator/'+idOrganization;
    let response = this.http.get(url,options).map(res => res.json()).catch(this.handleError);
    return response;
  }

	private handleError (error: Response | any) {
		// In a real world app, we might use a remote logging infrastructure
		let errMsg: string;
		if (error instanceof Response) {
			const body = error.json() || '';
			const err = body.error || JSON.stringify(body);
			errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
		} else {
			errMsg = error.message ? error.message : error.toString();
		}
		console.error(errMsg);
		return Promise.reject(errMsg);
	}

}
