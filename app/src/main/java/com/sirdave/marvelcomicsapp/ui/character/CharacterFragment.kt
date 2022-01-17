package com.sirdave.marvelcomicsapp.ui.character

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.sirdave.marvelcomicsapp.R
import com.sirdave.marvelcomicsapp.databinding.FragmentCharacterBinding
import com.sirdave.marvelcomicsapp.util.Constants
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CharacterFragment : Fragment() {

    private var _binding: FragmentCharacterBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CharacterViewModel by viewModels()
    private lateinit var characterName: TextView
    private lateinit var characterNameHeadline: TextView
    private lateinit var favouriteIcon: FloatingActionButton
    private lateinit var characterImage: ImageView
    private lateinit var characterDesc: TextView
    private lateinit var closeButton: ImageView

    private lateinit var isFavouriteFilled: Drawable
    private lateinit var isFavouriteBordered: Drawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getInt(Constants.CHARACTER_ID)?.let { characterId ->
            viewModel.searchCharacterById(characterId)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        _binding = FragmentCharacterBinding.inflate(inflater, container, false)
        val root: View = binding.root
        characterName = binding.characterName
        characterNameHeadline = binding.characterNameHeadline
        characterImage = binding.characterImage
        characterDesc = binding.characterDesc
        favouriteIcon = binding.favourite
        closeButton = binding.close

        isFavouriteFilled =  ContextCompat.getDrawable(requireContext(),
            R.drawable.ic_favourite_filled)!!


        isFavouriteBordered = ContextCompat.getDrawable(requireContext(),
            R.drawable.ic_favourite)!!

        viewModel.characterId.observe(viewLifecycleOwner, { character ->

            characterName.text = character.name
            characterNameHeadline.text = character.name
            characterDesc.text = character.description
            Glide.with(requireContext()).load(character.featuredImage).into(characterImage)
            favouriteIcon.setOnClickListener {
                if(favouriteIcon.drawable == isFavouriteFilled){
                    // remove from favourite
                    viewModel.deleteFavourite(character)
                    favouriteIcon.setImageDrawable(isFavouriteBordered)
                }
                else{
                    //add to favourite
                    viewModel.addNewFavourite(character)
                    favouriteIcon.setImageDrawable(isFavouriteFilled)
                }
            }

            closeButton.setOnClickListener {
                val navController = Navigation.findNavController(it)
                navController.popBackStack()
            }
        })

        return root
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }
}