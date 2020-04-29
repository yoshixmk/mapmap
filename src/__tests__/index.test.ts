import MapMap from 'src';
import StringKey from 'src/StringKey';

class Value<V> {
  private value: V;
  public constructor(value: V) {
    this.value = value;
  }
  public get(): V {
    return this.value;
  }
}

describe('greet', (): void => {
  test('if map has key, return true', (): void => {
    const mapmap = new MapMap<StringKey, string>();
    mapmap.set(new StringKey('hoge'), 'fuga');
    expect(mapmap.has(new StringKey('hoge'))).toBe(true);
  });

  test('if map has not key, return false', (): void => {
    const mapmap = new MapMap<StringKey, string>();
    mapmap.set(new StringKey('hoge'), 'fuga');
    expect(mapmap.has(new StringKey('bar'))).toBe(false);
  });

  test('yamashita', (): void => {
    const key1: StringKey = new StringKey('key 1');
    const key2: StringKey = new StringKey('key 3');
    const key3: StringKey = new StringKey('key 1');

    const value1: Value<string> = new Value('value');
    const value2: Value<string> = new Value('value');

    const mapmap: MapMap<StringKey, Value<string>> = new MapMap<StringKey, Value<string>>();

    expect(mapmap.has(key1)).toBe(false);
    expect(mapmap.has(key2)).toBe(false);
    expect(mapmap.has(key3)).toBe(false);

    mapmap.set(key1, value1);

    expect(mapmap.has(key1)).toBe(true);
    expect(mapmap.has(key2)).toBe(false);
    expect(mapmap.has(key3)).toBe(true);

    expect(mapmap.get(key1)).toBe(value1);
    expect(mapmap.get(key2)).toBe(undefined);
    expect(mapmap.get(key3)).toBe(value1);

    expect(mapmap.delete(key1)).toBe(true);

    expect(mapmap.has(key1)).toBe(false);
    expect(mapmap.has(key2)).toBe(false);
    expect(mapmap.has(key3)).toBe(false);

    mapmap.set(key1, value1);
    mapmap.set(key1, value2);

    expect(mapmap.get(key1)).toBe(value2);
    expect(mapmap.get(key2)).toBe(undefined);
    expect(mapmap.get(key3)).toBe(value2);
  });
});
