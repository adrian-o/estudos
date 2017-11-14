import { Injectable } from '@angular/core';
import { Task } from './model/task';

@Injectable()
export class TaskService {

  tasks: Array<Task>=[];

  constructor() { }

}
