import axios from "axios";
import { Manuscript } from "types";

export class Backend {
  private static readonly BASE = "./backend/";

  public static async getManuscriptList(): Promise<Manuscript[] | null> {
    const endpoint = "manuscripts";

    const manuscripts: Manuscript[] = await axios
      .get(Backend.BASE + endpoint)
      .then((res) => res.data)
      .catch(() => null);
    console.log(manuscripts[0].phrase);
    return manuscripts;
  }
}
