import { Component } from '@angular/core';
import { Student } from '../student';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-students-list',
  templateUrl: './students-list.component.html',
  styleUrl: './students-list.component.css'
})
export class StudentsListComponent {
  students: Student[];

  constructor(private studentService: StudentService){}

  ngOnInit(): void{
    this.getStudents();
  }

  private getStudents(){
    this.studentService.getStudentsList().subscribe(data =>{
      this.students = data;
    });
  }
  

}
