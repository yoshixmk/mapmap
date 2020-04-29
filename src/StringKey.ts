import Key from './Key';

export default class StringKey extends Key<string> {
  public equals(other: Key<string>): boolean {
    return this.get() === other.get();
  }
}
