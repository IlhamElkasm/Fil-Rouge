export interface User {
    userid: number;      // Utilisez 'number' pour correspondre au type Long
    username: string;    // Nom d'utilisateur
    email: string;       // Adresse email
    password: string;    // Mot de passe (notez que vous devriez éviter de stocker cela en clair)
    addresse: string;    // Adresse
    telephone: string;   // Numéro de téléphone
  }
  