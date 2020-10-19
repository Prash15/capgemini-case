import { ApplianceService } from './../appliance.service';
import { Appliance } from './../appliance';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-create-appliance',
  templateUrl: './create-appliance.component.html',
  styleUrls: ['./create-appliance.component.css']
})
export class CreateApplianceComponent implements OnInit {

  appliance: Appliance = new Appliance();
  submitted = false;

  constructor(private applianceService: ApplianceService) { }

  ngOnInit() {
  }

  newAppliance(): void {
    this.submitted = false;
    this.appliance = new Appliance();
  }

  save() {
    this.applianceService.createAppliance(this.appliance)
      .subscribe(data => console.log(data), error => console.log(error));
    this.appliance = new Appliance();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }
}