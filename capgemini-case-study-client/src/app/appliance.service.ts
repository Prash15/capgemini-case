import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApplianceService {

  private baseUrl = '/api/v1/appliances';

  constructor(private http: HttpClient) { }

  getAppliance(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createAppliance(appliance: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, appliance);
  }

  updateAppliance(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteAppliance(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getAppliancesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}