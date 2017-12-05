import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Task } from './model/task';

@Injectable()
export class TaskService {

  tasks: Array<Task>=[];

  constructor(private http:Http) { }

  getTasks():Promise<Array<Task>> {
    return this.http.get('http://localhost:8000/tasks')
              .toPromise()
              .then(response=>response.json());
  }

  createTask(task:Task) {
    return this.http.post('http://localhost:8000/tasks',task).toPromise();
  }
}
