import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'formatDate'
})
export class FormatDatePipe implements PipeTransform {

  transform(value: any, locale="pt-BR"): any {
    return new Intl.DateTimeFormat(locale).format(value);
  }

}