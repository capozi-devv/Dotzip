package devv.capozi.zip.common.util;

import org.joml.Vector3f;

import java.util.List;

public class MathUtils {
    /** -------------------------
     * BASIC UTILITIES
     * ------------------------- */
    public static float clamp(float value, float min, float max) {
        return Math.max(min, Math.min(max, value));
    }

    public static double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(max, value));
    }

    public static float lerp(float a, float b, float t) {
        return a + (b - a) * t;
    }

    public static double lerp(double a, double b, double t) {
        return a + (b - a) * t;
    }

    public static float wrap(float value, float min, float max) {
        float range = max - min;
        return ((value - min) % range + range) % range + min;
    }

    public static double wrap(double value, double min, double max) {
        double range = max - min;
        return ((value - min) % range + range) % range + min;
    }

    /* -------------------------
     * ANGLES & ROTATIONS
     * ------------------------- */

    public static float degToRad(float degrees) {
        return degrees * (float)Math.PI / 180f;
    }

    public static float radToDeg(float radians) {
        return radians * 180f / (float)Math.PI;
    }

    public static float angleDifference(float a, float b) {
        return wrap(b - a, -180f, 180f);
    }

    public static int shortestRotationDirection(float current, float target) {
        float diff = angleDifference(current, target);
        return diff > 0 ? 1 : (diff < 0 ? -1 : 0);
    }

    // Rotate a vector around an axis by angle in degrees
    public static Vector3f rotateAroundAxis(Vector3f vec, Vector3f axis, float angleDeg) {
        float rad = degToRad(angleDeg);
        float cos = (float)Math.cos(rad);
        float sin = (float)Math.sin(rad);

        Vector3f normAxis = new Vector3f(axis).normalize();
        float dot = vec.dot(normAxis);
        Vector3f cross = new Vector3f();
        vec.cross(normAxis, cross);

        return new Vector3f(
                vec.x * cos + cross.x * sin + normAxis.x * dot * (1 - cos),
                vec.y * cos + cross.y * sin + normAxis.y * dot * (1 - cos),
                vec.z * cos + cross.z * sin + normAxis.z * dot * (1 - cos)
        );
    }

    /* -------------------------
     * VECTOR HELPERS
     * ------------------------- */

    public static Vector3f cross(Vector3f a, Vector3f b) {
        return a.cross(b, new Vector3f());
    }

    public static Vector3f normalize(Vector3f v) {
        return new Vector3f(v).normalize();
    }

    public static float distance(Vector3f a, Vector3f b) {
        return new Vector3f(a).sub(b).length();
    }

    /* -------------------------
     * COLLISION HELPERS
     * ------------------------- */

    public static boolean aabbIntersect(float minAx, float minAy, float maxAx, float maxAy,
                                        float minBx, float minBy, float maxBx, float maxBy) {
        return (minAx < maxBx && maxAx > minBx &&
                minAy < maxBy && maxAy > minBy);
    }

    public static boolean polygonsIntersect(List<float[]> polygonA, List<float[]> polygonB) {
        return !separatingAxisExists(polygonA, polygonB) &&
                !separatingAxisExists(polygonB, polygonA);
    }

    private static boolean separatingAxisExists(List<float[]> polyA, List<float[]> polyB) {
        for (int i = 0; i < polyA.size(); i++) {
            float[] p1 = polyA.get(i);
            float[] p2 = polyA.get((i + 1) % polyA.size());
            float edgeX = p2[0] - p1[0];
            float edgeY = p2[1] - p1[1];

            float axisX = -edgeY;
            float axisY = edgeX;

            float[] rangeA = projectPolygon(polyA, axisX, axisY);
            float[] rangeB = projectPolygon(polyB, axisX, axisY);

            if (rangeA[1] < rangeB[0] || rangeB[1] < rangeA[0]) {
                return true;
            }
        }
        return false;
    }

    private static float[] projectPolygon(List<float[]> polygon, float axisX, float axisY) {
        float min = Float.MAX_VALUE;
        float max = -Float.MAX_VALUE;
        for (float[] point : polygon) {
            float projection = point[0] * axisX + point[1] * axisY;
            min = Math.min(min, projection);
            max = Math.max(max, projection);
        }
        return new float[]{min, max};
    }

    /* -------------------------
     * DISTANCE HELPERS
     * ------------------------- */

    public static float distance2D(float x1, float y1, float x2, float y2) {
        float dx = x2 - x1;
        float dy = y2 - y1;
        return (float)Math.sqrt(dx * dx + dy * dy);
    }

    public static float distance3D(float x1, float y1, float z1, float x2, float y2, float z2) {
        float dx = x2 - x1;
        float dy = y2 - y1;
        float dz = z2 - z1;
        return (float)Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    /* -------------------------
     * RANDOM HELPERS
     * ------------------------- */

    public static float randomRange(float min, float max) {
        return min + (float)Math.random() * (max - min);
    }

    public static int randomRangeInt(int min, int max) {
        return min + (int)(Math.random() * (max - min + 1));
    }
}