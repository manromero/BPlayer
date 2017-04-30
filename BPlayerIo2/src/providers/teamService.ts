import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions, Response} from '@angular/http';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

/*
 Generated class for the Team provider.

 See https://angular.io/docs/ts/latest/guide/dependency-injection.html
 for more info on providers and Angular 2 DI.
 */
@Injectable()
export class TeamService {

  API_ENDPOINT = 'http://localhost:8081/'

  constructor(public http: Http) {
    console.log('Constructor TeamService');
  }

  create(teamDto, token){
    let body = JSON.stringify(teamDto);
    let headers = new Headers({ 'Content-Type': 'application/json', 'Authorization' : token});
    let options = new RequestOptions({ headers: headers });
    var response = this.http.post(this.API_ENDPOINT+'team/create', body, options).map(res => res.json()).catch(this.handleError);
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
