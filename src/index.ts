import StringKey from './StringKey';

export default class MapMap<K extends StringKey /* union using | */, V> implements Map<K, V> {
  private collections: Map<K, V>;

  public readonly size: number;

  constructor() {
    this.collections = new Map<K, V>();
    this.size = 0;
  }

  public clear(): void{
    this.collections = new Map<K, V>();
  }
  public delete(key: K): boolean {
    const keys: IterableIterator<K> = this.collections.keys();
    const targetKey: K | undefined = Array.from(keys).find((k) => k.equals(key));
    if (targetKey !== undefined) {
      return this.collections.delete(targetKey);
    }
    return false;
  }
  public forEach(callbackfn: (value: V, key: K, map: Map<K, V>) => void, thisArg?: any): void {

  }
  public get(key: K): V | undefined {
    const entries = this.collections.entries();
    for (const e of entries) {
      if (e[0].equals(key)) {
        return e[1];
      }
    }
  }
  public has(key: K): boolean {
    const keys: IterableIterator<K> = this.collections.keys();
    return Array.from(keys).find((k) => k.equals(key)) !== undefined;
  }
  public set(key: K, value: V): this {
    this.collections.set(key, value);
    return this;
  }
  public entries(): IterableIterator<[K, V]> {
    throw new Error('Method not implemented.');
  }
  public keys(): IterableIterator<K> {
    throw new Error('Method not implemented.');
  }
  public values(): IterableIterator<V> {
    throw new Error('Method not implemented.');
  }
  public [Symbol.toStringTag]: string;
  public [Symbol.iterator](): IterableIterator<[K, V]> {
    throw new Error('Method not implemented.');
  }
}
