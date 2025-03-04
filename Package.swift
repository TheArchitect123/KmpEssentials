// swift-tools-version:5.5
import PackageDescription

let package = Package(
    name: "KmpEssentials",
    platforms: [
        .iOS(.v11) // Adjust minimum deployment target
    ],
    products: [
        .library(
            name: "KmpEssentials",
            targets: ["KmpEssentials"]
        )
    ],
    targets: [
        .binaryTarget(
            name: "KmpEssentials",
            path: "./shared/native/KmpEssentials.xcframework"
        )
    ]
)