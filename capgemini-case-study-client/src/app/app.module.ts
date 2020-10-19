import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { CreateApplianceComponent } from './create-appliance/create-appliance.component';
import { ApplianceDetailsComponent } from './appliance-details/appliance-details.component';
import { ApplianceListComponent } from './appliance-list/appliance-list.component';
import { FilterPipe } from './my-filter.pipe';
@NgModule({
  declarations: [
    AppComponent,
    CreateApplianceComponent,
    ApplianceDetailsComponent,
    ApplianceListComponent,
    FilterPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }