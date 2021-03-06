import { NgModule, ErrorHandler } from '@angular/core';
import { IonicApp, IonicModule, IonicErrorHandler } from 'ionic-angular';
import { MyApp } from './app.component';
import { HelloIonicPage } from '../pages/hello-ionic/hello-ionic';
import { ItemDetailsPage } from '../pages/item-details/item-details';
import { ListPage } from '../pages/list/list';
import { Register } from '../pages/register/register';
import { Login } from '../pages/login/login';
import { Main } from '../pages/main/main';
import { CreateOrganization } from '../pages/createOrganization/createOrganization';
import { MyOrganizations } from '../pages/myOrganizations/myOrganizations';
import { CreateTeam } from '../pages/createTeam/createTeam';
import { DetailsOrganization } from '../pages/detailsOrganization/detailsOrganization';
import { CreatePlayer } from '../pages/createPlayer/createPlayer';
import { MyTeams } from '../pages/myTeams/myTeams';
import { MyPlayers } from '../pages/myPlayers/myPlayers';
import { DetailsTeam } from '../pages/detailsTeam/detailsTeam';
import { CreateMatch } from '../pages/createMatch/createMatch';

import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';

import { AuthHttp, AuthConfig } from 'angular2-jwt';
import { Http } from '@angular/http';
import { Storage, IonicStorageModule } from '@ionic/storage';

let storage = new Storage();

export function getAuthHttp(http) {
  return new AuthHttp(new AuthConfig({
    headerPrefix: 'Bearer',
    noJwtError: true,
    globalHeaders: [{'Accept': 'application/json'}],
    tokenGetter: (() => storage.get('id_token')),
  }), http);
}

@NgModule({
  declarations: [
    MyApp,
    HelloIonicPage,
    ItemDetailsPage,
    ListPage,
	  Register,
	  Login,
	  Main,
    CreateOrganization,
    MyOrganizations,
    CreateTeam,
    DetailsOrganization,
    CreatePlayer,
    MyTeams,
    MyPlayers,
    DetailsTeam,
    CreateMatch
  ],
  imports: [
    IonicModule.forRoot(MyApp),
	IonicStorageModule.forRoot()
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    HelloIonicPage,
    ItemDetailsPage,
    ListPage,
	  Register,
	  Login,
	  Main,
    CreateOrganization,
    MyOrganizations,
    CreateTeam,
    DetailsOrganization,
    CreatePlayer,
    MyTeams,
    MyPlayers,
    DetailsTeam,
    CreateMatch
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
	{provide: AuthHttp,
      useFactory: getAuthHttp,
      deps: [Http]}
  ]
})
export class AppModule {}
