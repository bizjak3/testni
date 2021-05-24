import { Dogo } from "./dogo";
import { Service } from "./service";

export interface ServiceDiary {
  id?: number;
  assess?: number;
  status?: String;
  dogo?: Dogo;
  service?: Service;
}