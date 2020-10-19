import { ApplianceDetailsComponent } from './appliance-details/appliance-details.component';
import { CreateApplianceComponent } from './create-appliance/create-appliance.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ApplianceListComponent } from './appliance-list/appliance-list.component';

const routes: Routes = [
  { path: '', redirectTo: 'appliance', pathMatch: 'full' },
  { path: 'appliances', component: ApplianceListComponent },
  { path: 'details', component: ApplianceDetailsComponent },
  { path: 'add', component: CreateApplianceComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }