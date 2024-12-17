package org.example.nov2024;

import java.util.TreeMap;

public class CountUnguardedCellsintheGrid2257 {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        TreeMap<Integer, Person>[] rowWallAndGuard = new TreeMap[m];
        TreeMap<Integer, Person>[] columnWallAndGuard = new TreeMap[n];
        for (int i = 0; i < m; i++) {
            rowWallAndGuard[i] = new TreeMap<>();
        }
        for (int i = 0; i < n; i++) {
            columnWallAndGuard[i] = new TreeMap<>();
        }
        for (int i = 0; i < guards.length; i++) {
            int guardRow = guards[i][0];
            int guardCol = guards[i][1];
            Person guardPersonRow = new Person(Person.Type.GUARD, guardCol);
            rowWallAndGuard[guardRow].put(guardCol, guardPersonRow);

            Person guardPersonColumn = new Person(Person.Type.GUARD, guardRow);
            columnWallAndGuard[guardCol].put(guardRow, guardPersonColumn);
        }
        for (int i = 0; i < walls.length; i++) {
            int wallRow = walls[i][0];
            int wallCol = walls[i][1];
            Person wallPersonRow = new Person(Person.Type.WALL, wallCol);
            rowWallAndGuard[wallRow].put(wallCol, wallPersonRow);

            Person wallPersonColumn = new Person(Person.Type.WALL, wallRow);
            columnWallAndGuard[wallCol].put(wallRow, wallPersonColumn);
        }
        int count = 0;
        for (int row = 0; row < m; row++) {
            for (int column = 0; column < n; column++) {
                TreeMap<Integer, Person> columnCheck = columnWallAndGuard[column];
                // check top & bottom
                var columnCeil = columnCheck.ceilingEntry(row);
                var columnFloor = columnCheck.floorEntry(row);
                if ((columnCeil != null && columnCeil.getValue().isGuard()) || (columnFloor != null && columnFloor.getValue().isGuard())) {
                    continue;
                }

                TreeMap<Integer, Person> rowCheck = rowWallAndGuard[row];
                // check left & right
                var rowCeil = rowCheck.ceilingEntry(column);
                var rowFloor = rowCheck.floorEntry(column);
                if ((rowCeil != null && rowCeil.getValue().isGuard()) || (rowFloor != null && rowFloor.getValue().isGuard())) {
                    continue;
                }
                count++;
            }
        }
        return count - walls.length;
    }

    class Person {
        Type type;
        int position;

        public Person(Type type, int position) {
            this.type = type;
            this.position = position;
        }

        enum Type {
            GUARD,
            WALL
        }

        boolean isGuard() {
            return type == Type.GUARD;
        }
    }
}
