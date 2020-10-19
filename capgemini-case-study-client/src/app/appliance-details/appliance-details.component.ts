import { Appliance } from './../appliance';
import { Component, OnInit, Input } from '@angular/core';
import { ApplianceService } from '../appliance.service';
import { ApplianceListComponent } from '../appliance-list/appliance-list.component';

@Component({
  selector: 'app-appliance-details',
  templateUrl: './appliance-details.component.html',
  styleUrls: ['./appliance-details.component.css']
})
export class ApplianceDetailsComponent implements OnInit {

  @Input() appliance: Appliance;

  constructor(private applianceService: ApplianceService, private listComponent: ApplianceListComponent) { }

  ngOnInit() {
  }
}