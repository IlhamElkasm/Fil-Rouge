import { GateauDto } from "./GateauDto";
import { User } from "./User";

export interface Cart {
    cartId: number; // Utilisez 'number' car les ID générés sont souvent des nombres
    gateau: GateauDto; // Type pour le gâteau associé
    user: User; // Type pour l'utilisateur associé
  }