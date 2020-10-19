import { Observable } from "rxjs";
import { ApplianceService } from "./../appliance.service";
import { Appliance } from "./../appliance";
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-appliance-list",
  templateUrl: "./appliance-list.component.html",
  styleUrls: ["./appliance-list.component.css"]
})
export class ApplianceListComponent implements OnInit {
  appliances: Observable<Appliance[]>;

  constructor(private applianceService: ApplianceService) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.appliances = this.applianceService.getAppliancesList();
  }

  deleteAppliance(id: number) {
    this.applianceService.deleteAppliance(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }
}
