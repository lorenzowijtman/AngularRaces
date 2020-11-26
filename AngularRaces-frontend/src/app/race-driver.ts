
export class RaceDriver {
    name: string;
    finishPosition: number;

    constructor(name: string, finishPosition: number) {
        this.name = name;
        this.finishPosition = finishPosition;
    }

    getName() {
        return this.name;
    }

    setName(name: string) {
        this.name = name;
    }

    getFinishPosition() {
        return this.finishPosition;
    }

    setFinishPosition(finishPosition: number) {
        this.finishPosition = finishPosition;
    }


}
