export class Task {
    name: string;
    value: number;
    date_launch:Date;

    constructor() {
        this.name = '';
        this.value = 0;
        this.date_launch = new Date();
    }
}