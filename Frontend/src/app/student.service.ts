import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from './student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  private baseURL = "http://localhost:8081/student/getAll";
  private addURL = "http://localhost:8081/student/add";

  constructor(private httpClient: HttpClient) { }

  getStudentsList(): Observable<Student[]>{
    return this.httpClient.get<Student[]>(`${this.baseURL}`);
  }

  createStudent(student: Student): Observable<Object>{
    return this.httpClient.post(`${this.addURL}`,student)
  }
}
