type Genre = "ACTION" | "COMEDY" | "THRILLER" | "HORROR" | "DRAMA";

interface ActorDto {
    dateOfBirth: Date | null;
    firstName: string;
    lastName: string;
}

interface MovieWithActorDto {
    actors: ActorDto[];
    id: number | null;
    name: string;
    producerName: string;
    releaseDate: Date;
}