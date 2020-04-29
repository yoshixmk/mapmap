export default abstract class Key<K> {
  private key: K;
  public constructor(key: K) {
    this.key = key;
  }
  public get(): K {
    return this.key;
  }
  abstract equals(other: Key<K>): boolean;
}
