import { Component } from '@angular/core';
import { Task } from '../model/task';
import { TaskService } from '../task.service';

@Component({
  selector: 'task-new',
  templateUrl: './task-new.component.html',
  styleUrls: ['./task-new.component.css']
})
export class TaskNewComponent {

  tasks: Array<Task>;

  constructor(private taskService:TaskService) {
    this.tasks = this.taskService.tasks;
  }

  task:Task = new Task();

  add(){
    this.tasks.push(this.task);
    this.task = new Task();
  }

}
