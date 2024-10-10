import { FormDto } from "./Form";
import { GarnitureDto } from "./Garniture";
import { SaveurDto } from "./Saveur";

export interface cake {
    idGateau?: number;
    message: string;
    prixtotal?: number;
    forme?: FormDto; // If the API has 'forme' instead of 'form'
    saveur?: SaveurDto; 
    garnitures?: GarnitureDto; // Ensure this matches the API response
  }