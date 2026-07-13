package devv.capozi.zip.common.api;

import com.mojang.authlib.GameProfile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class DataConstants {
    public static final List<UUID> capozi_uuid = List.of(UUID.fromString("e8d6e412-351a-4165-adc3-d46db2a9e561"));
    public static final List<UUID> friendUUIDs = List.of(
            UUID.fromString("7ff48339-5661-4e68-96dc-3d6ff0d40842"), // guy
            UUID.fromString("9f82e696-89df-4780-97b2-e1c72c091114"), // koi
            UUID.fromString("918a33b5-af8a-402c-95e4-3d2cebe7af37"), // muddy
            UUID.fromString("f34e93a7-f7eb-4128-bd50-e8cd23b3cee6"), // sue
            UUID.fromString("6fd9222a-f604-4f81-a9ec-0814adcca005"), // wren
            UUID.fromString("0a81d57a-eb79-48d1-ab0a-bdd6963e19b9"), // fishy
            UUID.fromString("0fd23e1b-5112-40d9-8d4c-e0545f85178b"), // squishy
            UUID.fromString("0b057fca-1622-4e23-9044-0c363215bb33"), // eye
            UUID.fromString("39be881e-40d8-4afb-8458-12f4fc07c846"), // Hexader
            UUID.fromString("9aca6601-6414-4387-86ff-e4def7f5cebd"), // Arctic
            UUID.fromString("7700b3f5-0241-47a0-9df1-887254ef247b"), // RedJava
            UUID.fromString("ae445ba6-77ad-47fb-b1db-e582e46d2788"), // rustic
            UUID.fromString("1a3df47b-c05d-46fd-979b-77a6acbfd9e1"), // smipner
            UUID.fromString("14a34d5c-9840-43c1-8174-251ce81d6eea"), // unknown
            UUID.fromString("ec23b8cd-fb66-4d9b-83b9-d748c0b05e6e"), // yuuki
            UUID.fromString("7a4a8f5e-acd5-41d7-9e3d-998bfd623c3d"), // Lazy
            UUID.fromString("0ec5dee7-d32a-44db-9b9d-c03b05459c65"), // Chaos
            UUID.fromString("bf5000b2-652c-45a7-9601-0412cb9fe222"), // Bon
            UUID.fromString("dc9bd9f4-ef4d-4059-b21c-fd4823f69ae1"), // Boxed
            UUID.fromString("97808c20-2d4d-45d3-9f89-a0cc1e7a20a7"), // Hishadi
            UUID.fromString("b73f3a2d-de3c-4d06-8c15-c71c298ab48d"), // Snapy
            UUID.fromString("8dbebb74-01dd-4f62-b61d-09e1f6126e58"), // Watt
            UUID.fromString("739a71eb-d38c-409c-933a-b43660958c3c"), // Nico
            UUID.fromString("9db34e33-105d-4412-8ac0-2316b7ad4ef1"), // origin
            UUID.fromString("5fc814d8-e485-4977-be1f-e1bb028c1929"), // farzad
            UUID.fromString("4de70f2f-8535-474c-ac9a-0a9f8eb82f8a"), // Spooks
            UUID.fromString("9a5abccf-5013-423d-b137-453b13f07cab"), // everest
            UUID.fromString("87d00b3c-4486-463d-ad9c-f8baed3fec71"), // eyalego
            UUID.fromString("9da4f059-fb15-4b34-a2e5-54cfecf7c22e"), // Kindling
            UUID.fromString("b98321a1-933b-4517-98ac-d5b70c8966f2"), // moth
            UUID.fromString("c7ef1f45-bc5a-4b59-9434-62e6d1fb4770")); // cosmo
    public static Map<GameProfile, String> playerColors = new HashMap<>();
}
