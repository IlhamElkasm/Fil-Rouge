export interface CommandeDto {
    idCommende?: number; // Optional as it might not be provided on creation
    dateCommende: Date;
    gateauId: number; // Reference to Gateau
}
