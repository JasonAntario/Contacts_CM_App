//
//  ComposeView.swift
//  iosContactsApp
//
//  Created by Dmitry Sankovsky on 4.01.24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared
import Foundation

struct ComposeView: UIViewControllerRepresentable {
    
    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) {}
    
    func makeUIViewController(context: Context) -> some UIViewController {
        MainViewControllerKt.MainViewController()
    }
    
}
